package duke.commands;

import duke.exceptions.NoSuchTaskException;
import duke.tasks.TaskList;

/**
 * Encapsulates the information for a Command object.
 * Subclasses of Command has to implement the body for executeCommand method.
 */
public abstract class Command {

    /**
     * The action to be taken by the chat bot.
     *
     * @param taskList The list containing the tasks of the user.
     * @throws NoSuchTaskException May be thrown if the chat bot cannot find the task to execute the command.
     */
    public abstract String executeCommand(TaskList taskList) throws NoSuchTaskException;
}
