package testExtensivility;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import pa.iscde.javaTasks.ext.TasksServices;

public class Activator implements BundleActivator {

	private static Activator instance;
	private TasksServices taskService;
	
	public static Activator getInstance() {
		return instance;
	}
	
	@Override
	public void start(BundleContext bundleContext) throws Exception {
		instance = this;
		ServiceReference<TasksServices> tasksServiceReference = bundleContext
				.getServiceReference(TasksServices.class);
		taskService = bundleContext.getService(tasksServiceReference);
		taskService.update();
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		// TODO Auto-generated method stub

	}

	public TasksServices getTaskService() {
		return taskService;
	}
}
