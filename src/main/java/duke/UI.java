package duke;

public class UI {

    String greet = "Hello! I'm ELIAS\n" +
            "     What can I do for you?";

    String logo = "███████╗██╗     ██╗ █████╗ ███████╗\n" +
            "██╔════╝██║     ██║██╔══██╗██╔════╝\n" +
            "█████╗  ██║     ██║███████║███████╗\n" +
            "██╔══╝  ██║     ██║██╔══██║╚════██║\n" +
            "███████╗███████╗██║██║  ██║███████║\n" +
            "╚══════╝╚══════╝╚═╝╚═╝  ╚═╝╚══════╝\n";

    String bye = "Bye. Hope to see you again soon!";

    public UI() {

    }

    public String format(String s) {
        return "    ____________________________________________________________\n     " +
                s +
                "\n    ____________________________________________________________\n";
    }
}