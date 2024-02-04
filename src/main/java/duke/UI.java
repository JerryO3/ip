package duke;

public class UI {

    String greet = "Hello! I'm ELIAS\n" +
            "     What can I do for you?";

    String logo = "______ _ _\n" +
            "|  ____| (_)\n" +
            "| |__  | |_  __ _ ___\n" +
            "|  __| | | |/ _` / __|\n" +
            "| |____| | | (_| \\__ \\\n" +
            "|______|_|_|\\__,_|___/\n";

    String bye = "Bye. Hope to see you again soon!";

    public UI() {

    }

    public String format(String s) {
        return "    ____________________________________________________________\n     " +
                s +
                "\n    ____________________________________________________________\n";
    }
}
