# CGLib-for-Android
CGLib-for-Android (Dex code Generation Library for Android) is high level API to dynamicall generate sub class, its implementation based on DexMaker. This library use for AOP, method intercept, data access authorization authentication on Android.
<br>
## Usage
The usage of CGLib-for-Android is similar with CGLib, but CGLib only supports java byte code, CGLib-for-Android designed for dex code which runs on Android.

<br>
1 Download cglib-for-android.jar to your project
* library/lib-output/cglib-for-android.jar

<br>
2 Define the bussiness class which will be proxied in future
```Java
public class Printer {
    
    public void print() {
        Logger.d("Hello, world!");
    }

}
```

<br>
3 Define proxy class, need to implement MethodInterceptor
```Java
public class MyProxy implements MethodInterceptor {
    
    private Context context;
    
    public MyProxy(Context context) {
        this.context = context;
    }
    
    public Object getProxy(Class cls) {
        Enhancer e = new Enhancer(context);
        e.setSuperclass(cls);
        e.setInterceptor(this);
        return e.create();
    }

    @Override
    public Object intercept(Object object, Object[] args, MethodProxy methodProxy) throws Exception {
        Logger.d("begin print");
        Object result = methodProxy.invokeSuper(object, args);
        Logger.d("end print");
        return result;
    }

}
```

<br>
4 Get printer and run
```Java
Printer printer = (Printer) new MyProxy(this).getProxy(Printer.class);
printer.print();
```

Logcat output
<br>
[main:MyProxy.java:26 intercept]begin print
<br>
[main:Printer.java:6 print]Hello, world!
<br>
[main:MyProxy.java:28 intercept]end print


