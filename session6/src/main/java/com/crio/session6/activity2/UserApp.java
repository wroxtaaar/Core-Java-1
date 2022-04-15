package com.crio.session6.activity2;
import java.util.Scanner;

public class UserApp {

    /*
     *@objective: In the Whatsapp Application, at any given point of time, a user can create either an Image, Video or Text as his/her status
     *            and share it with the people connect through whatsapp with their phone numbers.We have tried to explain the
     *            Factory Design Pattern from this case study.
     */

    //attributes
    String userName, password;
    WhatsappStatus whatsappStatus;

    //Parameterized Constructor
    UserApp(String userName, String password) {
        this.userName = userName;
        this.password = password;
        whatsappStatus = new WhatsappStatus();
    }


    public void setUserName(String userName) {
        //to set the username
        this.userName = userName;
    }

    public void setPassword(String password) {
        //to set the password
        this.password = password;
    }

    public void setWhatsappStatus(String typeOfView, String source) {
        //to set the Whatsapp status for the user
        this.whatsappStatus = new WhatsappStatus();
        this.whatsappStatus.view = this.whatsappStatus.createViewForStatus(typeOfView, source);
    }

    public static void main(String... args) {
        String userName, password, answer;

        Scanner scanner = new Scanner(System.in);

        //to accept the username and password from user for logging in
        System.out.println("Enter username:");
        userName = scanner.next();
        System.out.println("Enter password:");
        password = scanner.next();

        UserApp userAppOne = new UserApp(userName, password);

        System.out.println("You are now logged in!");

        //to take an input from the user whether he/she wants to share a status.
        System.out.println("Share your Status with the world?(yes/no)");
        answer = scanner.next();

        String choiceOfView = "", content = "";
        View localGalleryView;

        while (answer.compareToIgnoreCase("yes") == 0) {

            //to take an input from user for what type of status he/she would like to share.
            System.out.println("Choose the type of your Status :Image,Text,Video");
            choiceOfView = scanner.next();

            //to take an input from the user providing the content for the Status
            System.out.println("Provide the content for your Status :");
            content = scanner.next();

            //creating the status
            userAppOne.whatsappStatus.view = userAppOne.whatsappStatus.createViewForStatus(choiceOfView, content);
            //publishing the status
            userAppOne.whatsappStatus.publish();
            //displaying the contents of the status
            userAppOne.whatsappStatus.view.displayMedia();

            //saving the whatsapp status content in the local gallery of the user
            localGalleryView = userAppOne.whatsappStatus.save();

            //removing the status
            userAppOne.whatsappStatus.remove();


            //to displaying the contents of the status saved in user's gallery
            System.out.println("Details of status saved in gallery :");
            localGalleryView.displayMedia();

            //to take an input from the user whether s/he wants to share another status.
            System.out.println("Do you want to post another status? (yes/no)");
            answer = scanner.next();

        }

        System.out.println("Thank you!");
        System.out.println("Logged out!");
        scanner.close();
    }

}
