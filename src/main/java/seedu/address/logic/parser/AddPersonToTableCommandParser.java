package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TABLE_ID;

import java.util.stream.Stream;

import seedu.address.logic.commands.AddPersonToTableCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.person.Name;

/**
 * Parses input arguments and creates a new AddGuestToTableCommand object
 */
public class AddPersonToTableCommandParser implements Parser<AddPersonToTableCommand> {
    /**
     * Parses the given {@code String} of arguments in the context of the AddGuestToTableCommand
     * and returns a AddGuestToTableCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    @Override
    public AddPersonToTableCommand parse(String args) throws ParseException {
        ArgumentMultimap argMultimap =
            ArgumentTokenizer.tokenize(args, PREFIX_NAME, PREFIX_TABLE_ID);

        if (!arePrefixesPresent(argMultimap, PREFIX_NAME, PREFIX_TABLE_ID)
            || !argMultimap.getPreamble().isEmpty()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                AddPersonToTableCommand.MESSAGE_USAGE));
        }
        //Getting all the details of the guest
        Name name = ParserUtil.parseName(argMultimap.getValue(PREFIX_NAME).get());
        int tableId = ParserUtil.parseTableId(argMultimap.getValue(PREFIX_TABLE_ID).get());

        return new AddPersonToTableCommand(name, tableId);
    }

    private static boolean arePrefixesPresent(ArgumentMultimap argumentMultimap, Prefix... prefixes) {
        return Stream.of(prefixes).allMatch(prefix -> argumentMultimap.getValue(prefix).isPresent());
    }
}
