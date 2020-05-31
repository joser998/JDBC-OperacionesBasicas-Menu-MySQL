package test;

import datos.PersonaJDBC;
import domain.Persona;
import java.util.*;

public class ManejoPersonas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opc = 0, id = 0;
        String nombre="", apellido="", email="", telefono="";
        PersonaJDBC personaJDBC = new PersonaJDBC();
        Persona persona = new Persona();
        
        do{
        System.out.println("Bienvenid@ a Base de Datos Registro de Personas.\n\nSelecciona una opcion:\n1.-Informacion."
                + "\n2.-Agregar Registro.\n3.-Actualizar Registro.\n4.-Eliminar Registro.\n5.-Salir.\n");
        opc = sc.nextInt();
        switch (opc) {
            case 1:
                //Select: Ver Registro
                List<Persona> personas = personaJDBC.select();
                System.out.println();
                for (Persona mostrar : personas) {
                    System.out.println("Base de Datos Persona: " + mostrar);
                }
                System.out.println("\n\n");
                break;
            case 2:
                //Insert: Agregar Registro
                sc.nextLine();
                System.out.println("Registro: ");
                System.out.print("Inserta Nombre: ");
                nombre=sc.nextLine();
                persona.setNombre(nombre);
                System.out.print("Inserta Apellido: ");
                apellido=sc.nextLine();
                persona.setApellido(apellido);
                System.out.print("Inserta Email: ");
                email=sc.nextLine();
                persona.setEmail(email);
                System.out.print("Inserta Telefono: ");
                telefono=sc.nextLine();
                persona.setTelefono(telefono);
                System.out.println("\n\n");
                personaJDBC.insert(persona);
                break;
            case 3:
                //Update: Modificar Registro
                System.out.print("ID: ");
                id=sc.nextInt();
                sc.nextLine();
                System.out.print("Nombre: ");
                nombre=sc.nextLine();
                System.out.print("Apellido: ");
                apellido=sc.nextLine();
                System.out.print("Email: ");
                email=sc.nextLine();
                System.out.print("Telefono: ");
                telefono=sc.nextLine();
                
                persona.setId_persona(id);
                persona.setNombre(nombre);
                persona.setApellido(apellido);
                persona.setEmail(email);
                persona.setTelefono(telefono);
                personaJDBC.update(persona);
                break;
            case 4:
                    //Delete: Eliminar Registro
                    System.out.print("Inserta ID de registro a eliminar: ");
                    id=sc.nextInt();
                    persona.setId_persona(id); 
                    personaJDBC.delete(persona); 
                break;
            case 5: System.out.println("Fin del Programa...");
                break;
        }
        }while(opc!=5);
    }
}