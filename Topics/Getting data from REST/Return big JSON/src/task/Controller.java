package task;

import org.springframework.web.bind.annotation.*;

import java.util.*;

class Color {
    public String color;
    public String category;
    public String type;
    
    public Code code;
    
    

    
    public Color(String color, String category, String type, Code code) {
        this.color = color;
        this.category = category;
        this.type = type;
        this.code = code;
        
    }
    
    
}


class Code {
    
   
    public List<Integer> rgba = new ArrayList<>(4);
    public String hex;
    
    
    
    public Code (String r, String g, String b, String a,  String hex) {
        this.hex = hex;
        this.rgba = convertStringsToIntegerList(r, g, b, a);
    }
    
    //method to convert stirng to int array 
    
    public List<Integer> convertStringsToIntegerList(String r, String g, String b, String a) {
        rgba.add(Integer.parseInt(r));
        rgba.add(Integer.parseInt(g));
        rgba.add(Integer.parseInt(b));
        rgba.add(Integer.parseInt(a));
        return rgba;
    }
    
    
    public List<Integer> getRgba() {
        return rgba;
    }
    
}

@RestController
public class Controller {
    
    
    public Color black = new Color("black", "hue", "primary", new Code ("0", "0", "0", "1", "#000"));
    public Color white = new Color("white", "value", "primary", new Code ("255", "255", "255", "1", "#FFF"));
    
    
    List<Color> colorList = List.of(black, white);
    
    Map<String, List<Color>> colorsMap = new HashMap<>(Map.ofEntries(
        Map.entry("colors", colorList)
    ));
    
   
    
    
    @GetMapping("/colors")
    public Map<String, List<Color>> getColorsController() {
        return colorsMap;
    }

}