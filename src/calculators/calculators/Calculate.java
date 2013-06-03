package calculators.calculators;

import calculators.annotations.Operation;
import tree.Operator;
import tree.Type;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Set;
import org.reflections.Reflections;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;

public class Calculate {

    private HashMap<String, Method> methods = new HashMap<>();

    public Calculate() {
        Reflections ref = new Reflections(new ConfigurationBuilder().setUrls(ClasspathHelper.forJavaClassPath()));
        insertReflectMethods(ref.getSubTypesOf(Calculator.class));
    }

    private String captureMethodSignature(Method method) {
        String signature = method.getName();
        Class<?>[] params = method.getParameterTypes();
        for (Class paramClass : params) {
            signature += paramClass.getSimpleName();
        }
        return signature;
    }

    private String captureMethodSignature(Operator operator, Object[] object) {
        String signature = operator.captureName();
        for (Object obj : object) {
            signature += obj.getClass().getSimpleName();
        }
        return signature;
    }

    private void insertReflectMethods(Set<Class<? extends Calculator>> classes) {
        for (Class<?> theClass : classes) {
            insertReflectMethods(theClass);
        }
    }

    private void insertReflectMethods(Class<?> theClass) {
        for (Method method : theClass.getDeclaredMethods()) {
            if (!method.isAnnotationPresent(Operation.class)) {
                continue;
            }
            methods.put(captureMethodSignature(method), method);
        }
    }

    public Type captureType(Operator operator, Type[] types) {
        try {
            String signature = captureMethodSignature(operator, types);
            return (Type) methods.get(signature).invoke(null, (Object[]) types);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {}
        return null;
    }
}
