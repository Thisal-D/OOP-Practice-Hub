// Abstraction
interface MessageService {
    void sendMessage(String message);
}

// Low-level modules implementing the interface
class EmailService implements MessageService {
    public void sendMessage(String message) {
        System.out.println("Sending email: " + message);
    }
}

class SMSService implements MessageService {
    public void sendMessage(String message) {
        System.out.println("Sending SMS: " + message);
    }
}

// High-level module depending on the abstraction
class NotificationService {
    private MessageService messageService;

    public NotificationService(MessageService messageService) {
        this.messageService = messageService;
    }

    public void sendNotification(String message) {
        messageService.sendMessage(message);
    }
}

// Usage
class Main {
    public static void main(String[] args) {
        // Dependency injection with EmailService
        EmailService emailService = new EmailService();
        NotificationService emailNotification = new NotificationService(emailService);
        emailNotification.sendNotification("Hello via Email");

        // Dependency injection with SMSService
        SMSService smsService = new SMSService();
        NotificationService smsNotification = new NotificationService(smsService);
        smsNotification.sendNotification("Hello via SMS");
    }
}
