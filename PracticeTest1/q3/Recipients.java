import java.util.ArrayList;

public class Recipients {
    private ArrayList<String> lines;
    public Recipients() {

    }
    public String extractCity(String cityZip) {
        int pos = cityZip.indexOf(",");
        return cityZip.substring(0, pos);
    }
    public String getAddress(String name) {
        String result = "";
        boolean start = false;
        for(String line : lines) {
            if(name.equals(line)) {
                start = true;
            }
            if(start)
                result += line + "\n";
            else
                continue;

            if (line.equals(""))
                break;
        }
        return result;

    }
}
