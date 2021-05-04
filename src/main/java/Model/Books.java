package Model;

public class Books {
    private int id;
    private String booksname;
    private String author;
    private String genre;
    private String rackno;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBooksname(){
        return booksname;
    }

    public void setBooksname(String booksname) {
        this.booksname = booksname;
    }

    public String getAuthor(){
        return author;
    }

    public void setAuthor(String author){
        this.author = author;
    }

    public String getGenre(){
        return genre;
    }

    public void setGenre(String genre){
        this.genre = genre;
    }

    public String getRackno(){
        return rackno;
    }

    public void setRackno(String rackno){
        this.rackno = rackno;
    }
}
