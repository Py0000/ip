package duke;

import duke.tasks.Task;
import duke.tasks.TaskList;

/**
 * Encapsulates the information of a Ui object that handles the interaction with the user.
 */
public class Ui {
    // Lines used to indicate a block of message
    private static final String LINE_HEAD = "\t____________________________________________________________";
    private static final String LINE_TAIL = String.format("\n%s\n", LINE_HEAD);

    private enum Message {
        WELCOME_MSG("Hello! I am Matthew!\n\t What can I do for you?"),
        EXIT_MSG("Good Bye. Don't have a good day... Have a great day!!!"),
        DISPLAY_LIST_MSG("\t There are the tasks you have:"),
        TASK_DONE_MSG("Well done! You have completed: \n\t  "),
        TASK_ADDED_MSG("Got it. I've added this task:\n\t   "),
        TASK_DELETED_MSG("Got it. I've deleted this task:\n\t   "),
        CHECK_TASK_COUNT_MSG(" tasks are in your list now!");


        private final String msg;

        Message(String msg) {
            this.msg = msg;
        }
    }


    private static void wrapMessageInLines(String msg) {
        String formattedMsg = String.format("%s\n\t %s%s", LINE_HEAD, msg, LINE_TAIL);
        System.out.println(formattedMsg);
    }

    public static void greetUser() {
        wrapMessageInLines(Message.WELCOME_MSG.msg);
    }

    public static void exit() {
        wrapMessageInLines(Message.EXIT_MSG.msg);
    }

    private static void displayListStart() {
        System.out.println(String.format("%s\n%s", LINE_HEAD, Message.DISPLAY_LIST_MSG.msg));
    }

    private static void displayListEnd() {
        System.out.println(LINE_TAIL);
    }

    public static void printCompleteTaskMessage(Task task) {
        wrapMessageInLines(Message.TASK_DONE_MSG.msg + task);
    }

    public static void displayList(TaskList taskList) {
        displayListStart();

        for (int i = 0; i < taskList.getTaskCount(); i++) {
            Task item = taskList.getTask(i);
            String itemDetails = String.format("\t %s.%s", (i + 1), item);

            System.out.println(itemDetails);
        }

        displayListEnd();
    }

    public static void printDeleteTaskMessage(Task task, int count) {
        String deletedTaskInfo = Message.TASK_DELETED_MSG.msg + task;
        String updatedListInfo = String.format("%d %s", count, Message.CHECK_TASK_COUNT_MSG.msg);
        wrapMessageInLines(deletedTaskInfo + "\n\t " + updatedListInfo);
    }

    public static void printAddTaskMessage(Task task, int count) {
        String addedTaskInfo = Message.TASK_ADDED_MSG.msg + task;
        String updatedListInfo = String.format("%d %s", count, Message.CHECK_TASK_COUNT_MSG.msg);
        wrapMessageInLines(addedTaskInfo + "\n\t " + updatedListInfo);
    }

    public static void notifyError(String errorMsg) {
        wrapMessageInLines(errorMsg);
    }




}
