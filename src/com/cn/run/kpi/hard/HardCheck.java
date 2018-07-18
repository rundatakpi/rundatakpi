package com.cn.run.kpi.hard;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

/**
 * 硬件 检测
 * 
 * @author Administrator
 *
 */
public class HardCheck {
 
	/**
	 * 硬件 检测 
	 * @param ip  ip地址
	 * @param port  端口号
	 * @param tinout  延时时间
	 * @return
	 */
	public boolean hardCheck(String ip,int port,int tinout) {
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
