package seedu.address.logic;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import seedu.address.logic.parser.Prefix;
import seedu.address.model.person.Person;

/**
 * Container for user visible messages.
 */
public class Messages {

    public static final String MESSAGE_UNKNOWN_COMMAND = "Unknown command";
    public static final String MESSAGE_INVALID_COMMAND_FORMAT = "Invalid command format! \n%1$s";
    public static final String MESSAGE_INVALID_PERSON_DISPLAYED_INDEX = "The person index provided is invalid";
    public static final String MESSAGE_PERSONS_LISTED_OVERVIEW = "%1$d persons listed!";
    public static final String MESSAGE_DUPLICATE_FIELDS =
                "Multiple values specified for the following single-valued field(s): ";
    public static final String MESSAGE_UNKNOWN_PERSON_NAME = "The person with the name '%s' not found!";
    public static final String MESSAGE_UNKNOWN_TABLE_ID = "The table with the id %d not found!";
    public static final String MESSAGE_NO_CURRENT_WEDDING = "No current wedding set. Please use 'setWedding' first.";
    public static final String MESSAGE_TABLE_FULL = "Table with ID %d is full!";
    public static final String MESSAGE_INVALID_TABLE_ID = "Please input a number between 1 and 100, inclusive, "
        + "for the table id!";
    public static final String MESSAGE_INVALID_TABLE_CAPACITY = "Please input a number between 1 and 100, inclusive, "
        + "for the table capacity!";
    public static final String MESSAGE_UNKNOWN_WEDDING_NAME = "There is no wedding with the name: %s";
    public static final String MESSAGE_INVALID_WEDDING_NAME = "Wedding name cannot be empty";

    /**
     * Returns an error message indicating the duplicate prefixes.
     */
    public static String getErrorMessageForDuplicatePrefixes(Prefix... duplicatePrefixes) {
        assert duplicatePrefixes.length > 0;

        Set<String> duplicateFields =
                Stream.of(duplicatePrefixes).map(Prefix::toString).collect(Collectors.toSet());

        return MESSAGE_DUPLICATE_FIELDS + String.join(" ", duplicateFields);
    }

    /**
     * Formats the {@code person} for display to the user.
     */
    public static String format(Person person) {
        final StringBuilder builder = new StringBuilder();
        builder.append("Name: ")
                .append(person.getName())
                .append("; Phone: ")
                .append(person.getPhone())
                .append("; Email: ")
                .append(person.getEmail())
                .append("; Address: ")
                .append(person.getAddress())
                .append("; Tags: ")
                .append(person.getTags().stream().map(tag -> tag.tagName).collect(Collectors.toList()))
                .append("; Dietary Restriction: ")
                .append(person.getDietaryRestriction())
                .append("; RSVP: ")
                .append(person.getRsvp())
                .append("; Table: ")
                .append(person.getTableIdString());
        person.getTags().forEach(builder::append);
        return builder.toString();
    }

}
