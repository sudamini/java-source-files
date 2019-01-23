package com.practice.designpatterns.singleton;

/*
* Ensures that this class has only one instance and there is a global point of access.
* Ways to make this class thread safe:
* 1. Use eager instantiation. Initialize and create instance in a static initializer block.
* 2. Make getInstance() method synchronized.
* 3. Use double checked locking; first check whether instance is not initialized and synchronize the creation only if
* instance is null ( first time when this code block is called )
* if you are using multiple classloaders, you may end up with more than one instance of singleton. In such cases, you can
* specify classloader yourself.
*
*/
public class Singleton {
	
	protected static Singleton myInstance;
	// protected static Singleton myInstance = new Singleton();
	
	private Singleton() {
		System.out.println( "Creating Singleton Instance "); 
	}
	// access this method from anywhere in the code by using Singleton.getInstance()
	//
	protected Singleton getInstance() {
		if( myInstance == null ) { // lazy instantiation
			synchronized ( Singleton.class ) { // this will be called only once - the first time when initialized.
				if ( myInstance == null ) { // check again
					myInstance = new Singleton();
				}
			}
			myInstance = new Singleton();
		}
		return myInstance;
	}

}
