import java.util.ArrayList;
import java.util.List;

class Member {
    private int memberID;
    private String firstName;
    private String lastName;
    private int age;
    private String membershipType; // Junior or Adult
    private String membershipTier; // Gold, Silver, or Bronze

    public Member(int memberID, String firstName, String lastName, int age, String membershipType, String membershipTier) {
        this.memberID = memberID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.membershipType = membershipType;
        this.membershipTier = membershipTier;
    }

    public boolean isJunior() {
        return "Junior".equalsIgnoreCase(membershipType);
    }

    public boolean isAdult() {
        return "Adult".equalsIgnoreCase(membershipType);
    }
}

class FitnessClass {
    private int classID;
    private String className;
    private String classType; // Junior or Adult
    private String classSchedule;

    public FitnessClass(int classID, String className, String classType, String classSchedule) {
        this.classID = classID;
        this.className = className;
        this.classType = classType;
        this.classSchedule = classSchedule;
    }

    public boolean isJuniorClass() {
        return "Junior".equalsIgnoreCase(classType);
    }

    public boolean isAdultClass() {
        return "Adult".equalsIgnoreCase(classType);
    }
}

class Booking {
    private int bookingID;
    private Member member;
    private FitnessClass fitnessClass;

    public Booking(int bookingID, Member member, FitnessClass fitnessClass) {
        this.bookingID = bookingID;
        this.member = member;
        this.fitnessClass = fitnessClass;
    }

    public boolean isValidBooking() {
        return (member.isAdult() && fitnessClass.isAdultClass()) || (member.isJunior() && fitnessClass.isJuniorClass());
    }
}

class GymSystem {
    private List<Member> members;
    private List<FitnessClass> fitnessClasses;
    private List<Booking> bookings;

    public GymSystem() {
        members = new ArrayList<>();
        fitnessClasses = new ArrayList<>();
        bookings = new ArrayList<>();
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public void removeMember(Member member) {
        members.remove(member);
    }

    public void createFitnessClass(FitnessClass fitnessClass) {
        fitnessClasses.add(fitnessClass);
    }

    public void deleteFitnessClass(FitnessClass fitnessClass) {
        fitnessClasses.remove(fitnessClass);
    }

    public boolean bookClass(Member member, FitnessClass fitnessClass) {
        Booking booking = new Booking(bookings.size() + 1, member, fitnessClass);
        if (booking.isValidBooking()) {
            bookings.add(booking);
            return true;
        }
        return false;
    }

    public boolean cancelBooking(Booking booking) {
        return bookings.remove(booking);
    }
}


