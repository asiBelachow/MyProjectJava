package view.dialogLoader;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;


/**
 * <h1>ClassGUIDialogLoader</h1><p>
 * A dialog loader (provided with an active shell) that dynamicly loads class's
 * fields to a form(Booleans are translated as checkboxes). On submit returns an
 * instance of that class
 */
public class ClassGUIDialogLoader {

	private Class<?> c;
	private Object instance;

	private SelectionListener submitListener, closeListener;

	private Shell dialogShell;
	private MessageBox msgBox;

	public ClassGUIDialogLoader(Shell shell, int style, Class<?> c) {
		super();
		this.c = c;
		this.instance = null;

		this.dialogShell = new Shell(shell, style);

		this.msgBox = new MessageBox(dialogShell);
	}

	public ClassGUIDialogLoader(Shell shell, int style, Class<?> c, Object existingValues) {
		super();
		this.c = c;
		this.instance = existingValues;

		this.dialogShell = new Shell(shell, style);

		this.msgBox = new MessageBox(dialogShell);
	}

	public void showDialog() {

		dialogShell.setText(c.getSimpleName());
		dialogShell.setLayout(new GridLayout(2, true));

		Group dialogFieldsGroup = new Group(dialogShell, SWT.SHADOW_ETCHED_IN);
		dialogFieldsGroup.setText(c.getSimpleName() + " Properties");
		dialogFieldsGroup.setLayout(new GridLayout(2, true));
		dialogFieldsGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));

		// dynamic fields injection
		ArrayList<Class<?>> classParamTypes = new ArrayList<Class<?>>();
		for (Field f : c.getDeclaredFields()) {
			// go over only the private fields
			if (Modifier.isPrivate(f.getModifiers()) && !Modifier.isFinal(f.getModifiers())) {
				String fieldName = f.getName();
				// field name
				new Label(dialogFieldsGroup, 0)
						.setText(fieldName.substring(0, 1).toUpperCase() + "" + fieldName.substring(1));

				// field value(editable) - not empty (already existing value)
				if (instance != null) {
					try {
						// instance's field's getter method
						Method method = instance.getClass().getMethod(
								"get" + fieldName.substring(0, 1).toUpperCase() + "" + fieldName.substring(1),
								new Class[0]);

						if (f.getType().equals(Boolean.class)) {
							if (((Boolean) method.invoke(instance, new Object[0])).booleanValue())
								new Button(dialogFieldsGroup, SWT.CHECK).setSelection(true);
							else
								new Button(dialogFieldsGroup, SWT.CHECK);
						} else {
							// try to fill the field with the value (using the
							// getter method if exists)
							new Text(dialogFieldsGroup, SWT.BORDER)
									.setText("" + method.invoke(instance, new Object[0]));
						}

					} catch (IllegalArgumentException | IllegalAccessException | SecurityException
							| NoSuchMethodException | InvocationTargetException e) {
						// fallback - no field value (no getter method or
						// problem with modifiers)
						if (f.getType().equals(Boolean.class))
							new Button(dialogFieldsGroup, SWT.CHECK);
						else
							new Text(dialogFieldsGroup, SWT.BORDER);
					}
				}
				// field value(editable) - empty
				else {
					if (f.getType().equals(Boolean.class))
						new Button(dialogFieldsGroup, SWT.CHECK);
					else
						new Text(dialogFieldsGroup, SWT.BORDER);
				}
				classParamTypes.add(f.getType());
			}
		}

		Button submitDialogBtn = new Button(dialogShell, SWT.PUSH);
		submitDialogBtn.setText("Ok");
		submitDialogBtn.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		submitDialogBtn.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				int i = 0;
				Object classValues[] = new Object[classParamTypes.size()];
				for (Control cntrl : dialogFieldsGroup.getChildren()) {
					if (cntrl instanceof Text) {

						// get text string value
						String stringValue = ((Text) cntrl).getText();
						try {
							// parse to correct wrapper class
							if (classParamTypes.get(i).equals(String.class)) {
								classValues[i] = stringValue;

							} else if (classParamTypes.get(i).equals(Integer.class)) {
								classValues[i] = Integer.parseInt(stringValue);

							} else if (classParamTypes.get(i).equals(Double.class)) {
								classValues[i] = Double.parseDouble(stringValue);

							} else if (classParamTypes.get(i).equals(Float.class)) {
								classValues[i] = Float.parseFloat(stringValue);

							} else if (classParamTypes.get(i).equals(Byte.class)) {
								classValues[i] = Byte.parseByte(stringValue);

							} else if (classParamTypes.get(i).equals(Short.class)) {
								classValues[i] = Short.parseShort(stringValue);

							} else if (classParamTypes.get(i).equals(Long.class)) {
								classValues[i] = Long.parseLong(stringValue);
							}
						} catch (NumberFormatException e) {
							showMessage("Wrong Values!", "Please insert correct values");
							break;
						}
						i++;
					} else if (cntrl instanceof Button) {
						if (classParamTypes.get(i).equals(Boolean.class)) {
							classValues[i] = ((Button) cntrl).getSelection();
							i++;
						}
					}

				}
				try {
					Class<?> classParamTypesArr[] = new Class<?>[classParamTypes.size()];
					Constructor<?> constructor = c.getConstructor(classParamTypes.toArray(classParamTypesArr));

					setInstance(constructor.newInstance(classValues));

				} catch (SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException
						| InvocationTargetException | NoSuchMethodException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				dialogShell.close();

				if (submitListener != null)
					submitListener.widgetSelected(arg0);
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub

			}
		});

		Button cancelDialogBtn = new Button(dialogShell, SWT.PUSH);
		cancelDialogBtn.setText("Cancel");
		cancelDialogBtn.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		cancelDialogBtn.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				dialogShell.close();

				if (closeListener != null)
					closeListener.widgetSelected(arg0);
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {

			}
		});

		dialogShell.pack();
		dialogShell.open();
	}

	public Object getInstance() {
		return instance;
	}

	public void setInstance(Object instance) {
		this.instance = instance;
	}

	public SelectionListener getSubmitListener() {
		return submitListener;
	}

	public void setSubmitListener(SelectionListener submitListener) {
		this.submitListener = submitListener;
	}

	public SelectionListener getCloseListener() {
		return closeListener;
	}

	public void setCloseListener(SelectionListener closeListener) {
		this.closeListener = closeListener;
	}

	private void showMessage(String title, String msg) {
		msgBox.setText(title);
		msgBox.setMessage(msg);
		msgBox.open();
	}

}
