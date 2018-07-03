# jvm-core-learning-example
包目录：

	├── org.jvmcore.classloader		// 类加载器
	├── org.javacore.heap		// 堆
	├── org.javacore.memory		// 内存
	├── org.javacore.stack		// 栈
	│
	拼命更新！顶！d=====(￣▽￣*)b

详细目录：

	├── README.md						// 项目唯一详细文档
	├── org.jvmcore.classloader	// 类加载器
	├── 	ClassLoaderInfoT.java		// 打印类加载器信息
	├── 	InitMain.java				// 子类的初始化过程和主动引用
	├── 	StringCL.java				// 类加载 - Class.forName
	├── 	UseFinalField.java			// Final字段不会被引起初始化
	├── org.javacore.heap			// 堆
	├── 	JvmXmxArgs.java				// 打印堆内存
	├── org.javacore.memory		// 内存
	├── 	FloatInJvm.java				// 输出浮点数在虚拟机的实际表示
	├── 	IntegerInJvm.java			// 负整形数在Jvm中的表示
	├── org.javacore.stack		// 栈
	├── 	LocalVarGC.java				// 打印GC信息
	├── 	StackDeep.java				// 堆溢出的理解
	拼命更新！顶！d=====(￣▽￣*)b

##学习方法
根据包目录，进行一块一块学习。然后针对某类，请看下相对应的test包或者src下直接测试案例，进行学习。
