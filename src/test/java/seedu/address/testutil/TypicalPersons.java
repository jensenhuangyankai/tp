package seedu.address.testutil;

import static seedu.address.logic.commands.CommandTestUtil.VALID_ADDRESS_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_ADDRESS_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_EMAIL_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_EMAIL_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_PHONE_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_PHONE_BOB;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.address.model.AddressBook;
import seedu.address.model.person.DietaryRestriction;
import seedu.address.model.person.Person;
import seedu.address.model.person.Rsvp;
import seedu.address.model.table.Table;
import seedu.address.model.wedding.Wedding;

/**
 * A utility class containing a list of {@code Person} objects to be used in tests.
 */
public class TypicalPersons {

    public static final Person ALICE = new PersonBuilder().withName("Alice Pauline")
        .withAddress("123, Jurong West Ave 6, #08-111").withEmail("alice@example.com")
        .withPhone("94351253").withRsvp(Rsvp.Status.YES)
        .withDietaryRestriction(DietaryRestriction.TypicalRestriction.NONE)
        .build();
    public static final Person BENSON = new PersonBuilder().withName("Benson Meier")
        .withAddress("311, Clementi Ave 2, #02-25").withEmail("johnd@example.com")
        .withPhone("98765432").withTable(2, 5).withRsvp(Rsvp.Status.NO)
        .withDietaryRestriction(DietaryRestriction.TypicalRestriction.VEGETARIAN)
        .build();
    public static final Person CARL = new PersonBuilder().withName("Carl Kurz").withPhone("95352563")
        .withEmail("heinz@example.com").withAddress("wall street").withTable(3, 5)
        .withRsvp(Rsvp.Status.YES).withDietaryRestriction(DietaryRestriction.TypicalRestriction.NONE).build();
    public static final Person DANIEL = new PersonBuilder().withName("Daniel Meier").withPhone("87652533")
        .withEmail("cornelia@example.com").withAddress("10th street").withTable(4, 5)
        .withRsvp(Rsvp.Status.YES).withDietaryRestriction(DietaryRestriction.TypicalRestriction.HALAL)
        .build();
    public static final Person ELLE = new PersonBuilder().withName("Elle Meyer").withPhone("9482224")
        .withEmail("werner@example.com").withAddress("michegan ave").withTable(5, 5)
        .withRsvp(Rsvp.Status.NO).withDietaryRestriction(DietaryRestriction.TypicalRestriction.NONE).build();
    public static final Person FIONA = new PersonBuilder().withName("Fiona Kunz").withPhone("9482427")
        .withEmail("lydia@example.com").withAddress("little tokyo").withTable(6, 5)
        .withRsvp(Rsvp.Status.YES).withDietaryRestriction(DietaryRestriction.TypicalRestriction.VEGAN).build();
    public static final Person GEORGE = new PersonBuilder().withName("George Best").withPhone("9482442")
        .withEmail("anna@example.com").withAddress("4th street").withTable(7, 5)
        .withRsvp(Rsvp.Status.YES).withDietaryRestriction(DietaryRestriction.TypicalRestriction.NONE).build();

    // Manually added
    public static final Person HOON = new PersonBuilder().withName("Hoon Meier").withPhone("8482424")
        .withEmail("stefan@example.com").withAddress("little india").withTable(8, 5)
        .withRsvp(Rsvp.Status.NO).withDietaryRestriction(DietaryRestriction.TypicalRestriction.NONE).build();
    public static final Person IDA = new PersonBuilder().withName("Ida Mueller").withPhone("8482131")
        .withEmail("hans@example.com").withAddress("chicago ave").withTable(9, 5)
        .withRsvp(Rsvp.Status.YES).withDietaryRestriction(DietaryRestriction.TypicalRestriction.NONE).build();

    // Manually added - Person's details found in {@code CommandTestUtil}
    public static final Person AMY = new PersonBuilder().withName(VALID_NAME_AMY).withPhone(VALID_PHONE_AMY)
        .withEmail(VALID_EMAIL_AMY).withAddress(VALID_ADDRESS_AMY)
        .withRsvp(Rsvp.Status.YES).withDietaryRestriction(DietaryRestriction.TypicalRestriction.NONE)
        .build();
    public static final Person BOB = new PersonBuilder().withName(VALID_NAME_BOB).withPhone(VALID_PHONE_BOB)
        .withEmail(VALID_EMAIL_BOB).withAddress(VALID_ADDRESS_BOB)
        .withRsvp(Rsvp.Status.NO).withDietaryRestriction(DietaryRestriction.TypicalRestriction.NONE)
        .build();

    public static final String KEYWORD_MATCHING_MEIER = "Meier"; // A keyword that matches MEIER

    private TypicalPersons() {} // prevents instantiation

    /**
     * Returns an {@code AddressBook} with all the typical persons.
     */
    public static AddressBook getTypicalAddressBook() {
        AddressBook ab = new AddressBook();
        ab.addWedding(new Wedding("John and Jane"));
        ab.setCurrentWeddingByName("John and Jane");
        for (Person person : getTypicalPersons()) {
            ab.addPerson(person);
        }
        return ab;
    }

    public static AddressBook getTypicalAddressBook2() {
        AddressBook ab = new AddressBook();

        ab.addWedding(new Wedding("John and Jane"));
        ab.setCurrentWeddingByName("John and Jane");

        Table t1 = new Table(1, 5);
        Table t2 = new Table(2, 5);
        Table t3 = new Table(3, 5);
        ab.addTable(t1);
        ab.addTable(t2);
        ab.addTable(t3);

        ab.addPerson(ALICE);
        Person newBenson = new Person(BENSON, -1);
        Person newCarl = new Person(CARL, -1);
        ab.addPerson(newBenson);
        ab.addPerson(newCarl);
        ab.addPersonToTableById(newBenson, 2);
        ab.addPersonToTableById(newCarl, 3);

        //ab.addWedding(new Wedding("Jack and Jill"));
        //ab.setCurrentWeddingByName("Jack and Jill");
        //Person new_daniel = new Person(DANIEL, null);
        //Person new_elle = new Person(ELLE, null);
        //ab.addPerson(new_daniel);
        //ab.addPerson(new_elle);
        //ab.addTable(new Table(4, 5));
        //ab.addTable(new Table(5, 5));
        //ab.addPersonToTable(new_daniel, 4);
        //ab.addPersonToTable(new_elle, 5);
        //
        //ab.setCurrentWeddingByName("John and Jane");
        return ab;
    }

    public static List<Person> getTypicalPersons() {
        return new ArrayList<>(Arrays.asList(ALICE, BENSON, CARL, DANIEL, ELLE, FIONA, GEORGE));
    }
}
