package com.cn.run.kpi.hard;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

/**
 * 硬件占用
 * 
 * @author Administrator
 *
 */
public class HardUseCheck {
  
	/**
	 * 硬件占用
	 * 
	 * @return
	 */
	public boolean hardUseCheck(String ip,int port,int tinout) {
		boolean flag = false;
		Socket socket = null;
		try {
			socket = new Socket();
			SocketAddress socketAddress = new InetSocketAddress(ip, port);
			socket.connect(socketAddress, tinout);
			flag = socket.isConnected();
		} catch (Exception e) {
			
		} finally {
			try {
				if (socket != null) {
					socket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		return flag;
	}
}
