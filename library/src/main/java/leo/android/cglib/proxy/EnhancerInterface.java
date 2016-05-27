package leo.android.cglib.proxy;

public interface EnhancerInterface {
	
	public void setMethodInterceptor$Enhancer$(MethodInterceptor methodInterceptor);
	
	@SuppressWarnings("rawtypes")
	public Object executeSuperMethod$Enhancer$(String methodName, Class[] argsType, Object[] argsValue);

}
