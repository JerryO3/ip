public class ToDo extends Item{
    private boolean isDone = false;
    private String name = "";
    public ToDo(String[] name) {
        for (int i = 1; i < name.length; i++) {
            this.name += name[i] + " ";
        }
        this.name = this.name.trim();
    }

    public ToDo(String[] info, boolean isDone) {
        this(info);
        this.isDone = isDone;
    }

    @Override
    public void markDone() {
        this.isDone = true;
    }

    @Override
    public void markUndone() {
        this.isDone = false;
    }

    @Override
    public String toString() {
        return "[T][" + printChecked(this.isDone)+ "] " + this.name;
    }

    public String toSaveFormat() {
        return saveIsDone(this.isDone) + "@T|" + this.name;
    }
}
