package agent;

import javassist.*;
import javassist.bytecode.MethodInfo;

import java.io.IOException;

/**
 * Created by yangyibo
 * Date: 2019/9/29
 * Time: 上午11:08
 */
public class JavaAgentTest {


	private static byte[] aspectFlinkKafka08Consumer(ClassPool classPool, String className)
			throws NotFoundException, CannotCompileException, IOException {

		CtClass ctClass = classPool.get(className);
		CtConstructor[] declaredConstructors = ctClass.getDeclaredConstructors();
		for (CtConstructor declaredConstructor : declaredConstructors) {
			MethodInfo methodInfo = declaredConstructor.getMethodInfo();
			int accessFlags = methodInfo.getAccessFlags();
			if (2 == accessFlags) {
				declaredConstructor.insertBefore("");
			}
		}
		return ctClass.toBytecode();
	}


}
