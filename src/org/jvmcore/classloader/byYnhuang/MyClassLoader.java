package org.jvmcore.classloader.byYnhuang;

import java.io.InputStream;

/**
 * 自定义类加载器,重写classloader的findclass方法
 * 
 * @author ynhuang
 *
 */
public class MyClassLoader {
	/**
	 * 匿名内部类实现自定义类加载器
	 * 
	 * @return
	 */
	public static ClassLoader getObject() {
		final ClassLoader classLoader = new ClassLoader() {
			@Override
			protected Class<?> findClass(String name) throws ClassNotFoundException {
				// 获取类的文件名
				String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
				InputStream inputStream = getClass().getResourceAsStream(fileName);
				try {
					byte[] b = new byte[inputStream.available()];
					return defineClass(name, b, 0, b.length);
				} catch (Exception e) {
					throw new ClassNotFoundException(name);
				}
			}
		};
		return classLoader;
	}

	/**
	 * jdk1.2之后的版本引入了双亲委派机制后，此处会返回true，需要得到false的结果需要把jdk的版本切换回1.2之前，不相同的原因其实很明显，
	 * org.jvmcore.classloader.byYnhuang.Sample是通过AppClassLoader这个加载器去加载的，obj使用的是自定义的类加载器
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		MyClassLoader myClassLoader = new MyClassLoader();
		ClassLoader classLoader = MyClassLoader.getObject();
		Object obj = classLoader.loadClass("org.jvmcore.classloader.byYnhuang.Sample").newInstance();
		System.out.println(obj instanceof org.jvmcore.classloader.byYnhuang.Sample);
		System.out.println(obj.getClass().getClassLoader());
		System.out.println(org.jvmcore.classloader.byYnhuang.Sample.class.getClassLoader());
		System.out.println(org.jvmcore.classloader.byYnhuang.Sample.class.getClassLoader().getParent());
	}
}
