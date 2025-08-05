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
			while (true) {
				System.out.println("Chọn chức năng: ");
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
					break;

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
