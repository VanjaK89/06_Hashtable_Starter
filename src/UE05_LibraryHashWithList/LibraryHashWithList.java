package UE05_LibraryHashWithList;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class LibraryHashWithList {

    private LinkedList<Book>[] list; //


    public LibraryHashWithList(int size) {
        list = new LinkedList[size];
    }

    public boolean addBook(Book newBook) {

        int index = getIndexByHashCalc(newBook.getId());

            if (list[index] == null)
            {
                list[index] = new LinkedList<Book>();
            }



            return list[index].add(newBook);


    }

    public Book getBookById(int id) {
           Book currentBook;
           LinkedList<Book> list1 = list[getIndexByHashCalc(id)];
           Iterator it = list1.iterator();
           while(it.hasNext()){
               currentBook = (Book)it.next();
               if(currentBook.getId() == id){
                   return currentBook;
               }
           }

        // Tipp: Beim Durchsuchen der LinkedList könnte ein Iterator hilfreich sein.
        return null;
    }

    public boolean removeBook(int id) {
        Book book = getBookById(id);
        if (book == null)
            return false;

        int index = getIndexByHashCalc(book.getId());
        LinkedList<Book> linkedList = list[index];
        linkedList.remove(book);


        return false;
    }

    public LinkedList<Book> getLinkedListAtPos(int pos) {

        return list[pos];

    }

    private int getIndexByHashCalc(int id) {

        return  id % list.length;
    }
}
