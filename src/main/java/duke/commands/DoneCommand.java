package duke.commands;

import duke.Ui;
import duke.exceptions.NoSuchTaskException;
import duke.tasks.Task;
import duke.tasks.TaskList;

/**
 * Encapsulates the information of a DoneCommand object that contains an id of the task.
 */
public class DoneCommand extends Command {
    private final int id;

    public DoneCommand(int id) {
        this.id = id;
    }

    @Override
    public void executeCommand(TaskList taskList) throws NoSuchTaskException {
        if (this.id >= 0 && this.id < taskList.getTaskCount()) {
            Task task = taskList.getTask(this.id);
            task.markAsComplete();
            Ui.printCompleteTaskMessage(task);
        } else {
            throw new NoSuchTaskException();
        }
    }
}
