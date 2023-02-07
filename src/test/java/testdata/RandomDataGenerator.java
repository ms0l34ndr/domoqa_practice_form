package testdata;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

public class RandomDataGenerator {
    public static Faker faker = new Faker();
    public static Random random = new Random();

    public static String getFirstName() {
        return faker.name().firstName();
    }

    public static String getLastName() {
        return faker.name().lastName();
    }

    public static String getEmail() {
        return faker.internet().emailAddress();
    }

    public static String getGender() {
        String[] genders = {
                "Male",
                "Female",
                "Other"
        };
        return genders[random.nextInt(genders.length)];
    }

    public static String getPhoneNumber() {
        return faker.phoneNumber().subscriberNumber(10);
    }

    public static String[] getDateOfBirth() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy", Locale.ENGLISH);
        return dateFormat.format(faker.date()
                .birthday())
                .split(" ");
    }

    public static String getSubject() {
        String[] subjects = {
                "Maths",
                "Accounting",
                "Arts",
                "Social Studies",
                "History",
                "Economics",
                "Biology",
                "Computer Science",
                "English",
                "Chemistry",
                "Physics",
                "Commerce",
                "Hindi",
                "Civics"
        };
        return subjects[random.nextInt(subjects.length)];
    }

    public static String getHobbie() {
        String[] hobbies = {
                "Sports",
                "Reading",
                "Music"
        };
        return hobbies[random.nextInt(hobbies.length)];
    }

    public static String getAddress() {
        return faker.address().fullAddress();
    }

    public static String getState() {
        String[] states = {
                "NCR",
                "Uttar Pradesh",
                "Haryana",
                "Rajasthan"
        };
        return states[random.nextInt(states.length)];
    }

    public static String getCity(String state) {
        Map<String, String[]> mapStateCity = new HashMap<>();
        mapStateCity.put("NCR", new String[]{"Delhi", "Gurgaon", "Noida"});
        mapStateCity.put("Uttar Pradesh", new String[]{"Agra", "Lucknow", "Merrut"});
        mapStateCity.put("Haryana", new String[]{"Karnal", "Panipat"});
        mapStateCity.put("Rajasthan", new String[]{"Jaipur", "Jaiselmer"});

        String[] cities = mapStateCity.get(state);
        return cities[random.nextInt(cities.length)];
    }

    public static String getPicture() {
        String[] pictures = {
                "demoC4t.jpg",
                "f0x.jfif",
                "favorite-hiking-place.png"
        };
        return pictures[random.nextInt(pictures.length)];
    }
}
