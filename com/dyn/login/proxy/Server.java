package com.dyn.login.proxy;

public class Server implements Proxy {

	/**
	 * @see forge.reference.proxy.Proxy#renderGUI()
	 */
	//renderGUI is all handled on client side
	@Override
	public void renderGUI() {
		// Actions on render GUI for the server (logging)

	}

	//Nothing to initialize
	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

}