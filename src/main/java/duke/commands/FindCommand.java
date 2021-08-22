package duke.commands;

import duke.Ui;
import duke.exceptions.NoSuchTaskException;
import duke.tasks.TaskList;

/**
 * Encapsulates the information of a FindCommand object that contains a keyword.
 */

public class FindCommand extends Command {
    private final String keyword;

    public FindCommand(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public void executeCommand(TaskList taskList) throws NoSuchTaskException {
        TaskList result = taskList.searchTaskByKeyword(this.keyword);

        if (result.getTaskCount() == 0) {
            Ui.printNoneMatchMessage();
        } else {
            Ui.displayList(result);
        }
    }
}
