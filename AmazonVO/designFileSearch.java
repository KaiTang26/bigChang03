public class Main {

    public static void main(String[] args) {

        File xmlF1 = new File("aaa.xml", "dfsdf");
        File xmlF2 = new File("bbb.xml", "dfsdfdfdf");
        File pdfF2 = new File("bbb.pdf", "dfsdfdfdf");
        File mp4F3 = new File("bdf.mp4", "dfsdfdfdf");

        Directory dir = new Directory("Home");

        dir.addEntry(xmlF1);
        dir.addEntry(xmlF2);
        dir.addEntry(pdfF2);
        dir.addEntry(mp4F3);

        SearchParameter sp = new SearchParameter();
        sp.extension = "mp4";
        sp.minSize = 6;

        FileSearcher fs = new FileSearcher();

        List<File> ans = fs.search(dir, sp);

        System.out.println(ans);




    }


}


class FileSearcher{

    private FilterFactor ff = new FilterFactor();

    public List<File> search(Directory dir, SearchParameter sp){

        List<File> ans = new ArrayList<>();

        for(File f : dir.getEntries()){
            boolean isValid = true;

            for(IFilter filter : ff.filters){
                if(!filter.isValid(sp, f)){
                    isValid = false;
                    break;
                }
            }

            if(isValid){
                ans.add(f);
            }
        }

        return ans;
    }

}

class SearchParameter{
    public String extension;
    public String name;
    public int minSize;
    public int maxSize;
}

interface IFilter{
    boolean isValid(SearchParameter sp, File file);
}

class NameFiler implements IFilter{

    public boolean isValid(SearchParameter sp, File file){
        if(sp.name==null){
            return true;
        }

            if(file.getName().equals(sp.name)){
                return true;
            }

        return  false;
    }
}

class ExtensionFilter implements IFilter{

    public boolean isValid(SearchParameter sp, File file){
        if(sp.extension==null){
            return true;
        }

            if(file.getExtension().equals(sp.extension)){
                return true;
            }

        return  false;
    }
}

class MinSizeFilter implements IFilter{

    public boolean isValid(SearchParameter sp, File file){
        if(sp.minSize==0){
            return true;
        }

            if(file.getSize()>= sp.minSize){
                return true;
            }

        return  false;
    }

}

class MaxSizeFilter implements IFilter{

    public boolean isValid(SearchParameter sp, File file){
        if(sp.maxSize==0){
            return true;
        }

            if(file.getSize()<= sp.maxSize){
                return true;
            }

        return  false;
    }

}


class FilterFactor{
   public List<IFilter> filters;

   public FilterFactor(){
       filters = new ArrayList<>();

       filters.add(new NameFiler());
       filters.add(new ExtensionFilter());
       filters.add(new MinSizeFilter());
       filters.add(new MaxSizeFilter());
   }
}






interface IEntry{
    String getName();
    int getSize();
    boolean isDirectory();
}


abstract class Entry implements IEntry{

    protected String name;
    protected int size;

    public Entry(String name){
        this.name = name;
        this.size = 0;
    }

    public void setSize(int size){
        this.size = size;
    }

    @Override
    public String getName(){
        return this.name;
    }
    @Override
    public  int getSize(){
        return this.size;
    }
}

class Directory extends Entry{

    private List<File> entries;

    public Directory(String name){
        super(name);
        entries = new ArrayList<>();
    }

    public  boolean isDirectory(){
        return true;
    }

    public void addEntry(File e){
        entries.add(e);
        calculateSize();
    }

    public  List<File> getEntries(){
        return entries;
    }

    private  void calculateSize(){
        int size = 0;
        for(Entry e:entries) {
            size += e.getSize();
        }
        setSize(size);
    }
}

class File extends Entry{

    private String content;

    public File(String name, String content){
        super(name);
        this.content = content;
        setSize(content.length());
    }

    @Override
    public boolean isDirectory() {
        return false;
    }

    public String getExtension(){
        return name.substring(name.indexOf(".")+1);
    }

    public String toString(){
        return "File: "+name;
    }
}

