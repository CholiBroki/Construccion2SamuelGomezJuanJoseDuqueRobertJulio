package app.adapter.in.user;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import app.application.usecase.StaffUseCase;
import app.domain.model.User;
@Controller
public class Role {
	

		private static final String MENU = "Ingrese una de las opciones \n 1. para crear doctor \n 2. para crear enfermera \n 3. para salir";
		private static Scanner reader = new Scanner(System.in);
		@Autowired
		private StaffUseCase staffUseCase;
	

		public void session() {
			boolean session = true;
			while (session) {
				session = menu();
			}
		}

		public boolean menu() {
			try {
				System.out.println(MENU);
				String option = reader.nextLine();
				switch (option) {
				case "1": {
					User user = createRole();
					staffUseCase.createdoctor(user);
					return true;
				}
				case "2": {
					User user = createRole();
					staffUseCase.createNurse(user);
					return true;
				}
				case "3": {
					System.out.println("hasta pronto \n cerrando sesion");
					return false;
				}
				default: {
					System.out.println("ingrese una opcion valida");
					return true;
				}
				}

			} catch (Exception e) {
				System.out.println(e.getMessage());
				return true;
			}
		}
		
		private User createRole() {
			// TODO Auto-generated method stub
			return null;
		}

		public Role () throws Exception{
			System.out.println("ingrese el nombre de la persona");
			String name = reader.nextLine();
			System.out.println("ingrese la cedula de la persona");
			String document = reader.nextLine();
			System.out.println("ingrese el nombre de de usuario");
			String userName = reader.nextLine();
			System.out.println("ingrese la contraseña");
			String password = reader.nextLine();
			System.out.println("ingrese la edad de la persona");
			String age = reader.nextLine();
			System.out.print(name);
			return;
			
		}

}
