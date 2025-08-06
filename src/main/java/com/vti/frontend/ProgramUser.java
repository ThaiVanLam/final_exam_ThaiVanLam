package com.vti.frontend;

import java.io.IOException;
import java.util.List;

import com.vti.controller.UserController;
import com.vti.dto.Project;
import com.vti.dto.User;
import com.vti.utils.ScannerUtils;

public class ProgramUser {

	public static void main(String[] args) {
		try {
			UserController userController = new UserController();
			outterLoop: while (true) {
				System.out.println("Chọn chức năng tổng quát: ");
				System.out.println("1.Khởi tạo dữ liệu");
				System.out.println("2.In thông tin member và leader theo project");
				System.out.println("3.Đăng nhập");
				System.out.println("4.Thoát khỏi chương trình");
				int choice = ScannerUtils.inputInt();
				switch (choice) {
				case 1:
					try {
						DataInitializer dataInitializer = new DataInitializer();
						dataInitializer.initData();
					} catch (Exception e) {
						System.out.println(e.getMessage());
						e.printStackTrace();
					}
					System.out.println("Khởi tạo dữ liệu thành công");
					break;
				case 2:
					System.out.println("Nhập id project để in ra thông tin member và leader:");
					int id = ScannerUtils.inputInt();
					Project project = new Project(id);
					userController.printMemberAndLeaderFromProject(project);
					break;
				case 3:
					// login
					System.out.println("Mời bạn login: ");
					System.out.println("Nhập email để login: ");
					String email = ScannerUtils.inputString();
					System.out.println("Nhập password để login: ");
					String password = ScannerUtils.inputString();
					User user;
					user = userController.login(email, password);
					if (user == null) {
						throw new Exception("Không tòn tại user này!");
					}
					System.out.println("Bạn đã đăng nhập vào user: " + user.getEmail());
					System.out.println("Loại user là: " + user.getUserType());
					String userType = user.getUserType();
					switch (userType) {
					case "leader":
						while (true) {
							System.out.println("Chức năng trong leader: ");
							System.out.println("1.Đăng xuất");
							System.out.println("Chọn chức năng trong leader: ");
							if (ScannerUtils.inputInt() == 1) {
								System.out.println("Đăng xuất thành công");
								continue outterLoop;
							}
						}
					case "member":
						while (true) {
							System.out.println("Chức năng trong member: ");
							System.out.println("1.Đăng xuất");
							System.out.println("Chọn chức năng trong member: ");
							if (ScannerUtils.inputInt() == 1) {
								System.out.println("Đăng xuất thành công");
								continue outterLoop;
							}
						}
					case "admin":
						adminLoop: while (true) {
							System.out.println("Chức năng trong admin: ");
							System.out.println("1.Tạo tài khoản");
							System.out.println("2.Đăng xuất");
							System.out.println("Chọn chức năng trong admin: ");
							int choiceInAdmin = ScannerUtils.inputInt();
							switch (choiceInAdmin) {
							case 1:
								System.out.println("Đang ở chức năng tạo tài khoản của employee");
								System.out.println();
								break;
							case 2:
								System.out.println("Đăng xuất thành công");
								continue outterLoop;
							default:
								break;
							}
						}
					default:
						break;
					}
					break;

				case 4:
					System.out.println("Thoát khỏi chương trình!");
					break outterLoop;
				default:
					break;
				}
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}

}
