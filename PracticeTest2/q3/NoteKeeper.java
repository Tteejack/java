import java.util.ArrayList;

public class NoteKeeper {
    private ArrayList<Note> noteList;

    public NoteKeeper(String[] notes) {
        noteList = new ArrayList<Note>();
        for(String note: notes) {
            noteList.add(new Note(note));
        }
    }
    public void printNotes() {
        for(int i = 1; i <= noteList.size(); i++) {
            System.out.println("" + i + ". "
                    + noteList.get(i-1).getNote());
        }
    }

    public void removeNotes(String str) {
        for(int i = 0; i < noteList.size(); ) {
            int pos = noteList.get(i).getNote().indexOf(str);
            if(pos >= 0)
                noteList.remove(i);
            else
                i++;
        }
    }

    public static void main(String[] args) {
        String[] notes = {
          "pick up drycleaning",
          "special dog chow",
          "car registration",
          "dentist Monday",
          "dog license"
        };

        NoteKeeper nk = new NoteKeeper(notes);
        nk.printNotes();
        nk.removeNotes("dog");
        System.out.println(" -- removing dog");
        nk.printNotes();
        System.out.println(" -- -- -- -- --");
        String[] notes1 = {
                "pick up car",
                "buy carrots",
                "dog license",
                "carpet clearning"
        };
        nk = new NoteKeeper(notes1);
        nk.printNotes();
        System.out.println(" -- removing car");
        nk.removeNotes("car");
        nk.printNotes();
    }
}
