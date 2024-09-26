import java.util.UUID;

public class UUIDValidator {
    public static boolean isValidUUID(String uuid) {
        try {
            UUID.fromString(uuid);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        String validUUID = "550e8400-e29b-41d4-a716-446655440000";
        String invalidUUID = "invalid-uuid";

        System.out.println("Valid UUID: " + isValidUUID(validUUID)); // Output: true
        System.out.println("Invalid UUID: " + isValidUUID(invalidUUID)); // Output: false
    }
}

