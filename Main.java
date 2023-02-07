package dz_5;


import java.util.*;


public class Main
{

    // Реализуйте структуру телефонной книги
    // с помощью HashMap, учитывая, что 1 человек
    // может иметь несколько телефонов.
    public static void main(String[] args)
    {
        Map<String, List<String>> book = new HashMap<>();
        book.put("Ольга", List.of("8 222 655 76 92", "8 887 675 65 56"));
        book.put("Юлия", List.of("8 333 987 99 88", "8 800 95 35 08"));
        book.put("Ирина", List.of("8 234 567 29 08", "8 876 456 54 32"));
        book.put("Екатерина", List.of("8 333 543 12 89", "8 008 800 09 87"));
        book.put("Валерия", List.of("8 432 765 22 33", "8 332 456 32 23"));

        menu(book);
    }

     public static String scan()
    {
        Scanner scanner = new Scanner(System.in);
        String scan = scanner.nextLine();

        return scan;
    }

    public static void find(Map<String, List<String>> phoneBook)

    {
        System.out.print("Имя абонента: ");
        String name = scan();
        System.out.println("Имя: "+ name +"\nТелефон(ы): "+ phoneBook.get(name));
    }

    public static void allBook(Map<String, List<String>> AllBook)
    // Печать книги
    {
        for (var item : AllBook.entrySet())
        {
            System.out.println("Имя: " + item.getKey() + "\nНомер" + item.getValue());
        }
    }

    public static Map<String, List<String>> add(Map<String, List<String>> book)

    {
        System.out.print("Имя абонента: ");
        String name = scan();
        List<String> data = new ArrayList<>();
        while (true) {
            System.out.println("Если номеров больше нет, введите '5'");
            System.out.print("Введите номер: ");
            String nomer = scan();
            if (nomer.equals("5")) {
                break;
            } else {
                data.add(nomer);
            }
        }
        book.put(name, data);

        return book;
    }

    public static Map<String, List<String>> menu(Map<String, List<String>> book) {
        while (true) {
            System.out.println( "    \n   Телефонная Книга\n  " +
                    "        Меню: \n1. Найти контакт \n2. Добавить контакт"+
                    " \n3. Печать телефонной книги \n4. Выход");
            System.out.print("\nвыберите пункт меню-> ");
            String comands = scan();
            if (comands.equals("4")) {
                break;
            } else {
                switch (comands) {
                    case "1":
                        find(book);
                        break;
                    case "2":
                        add(book);
                        break;
                    case "3":
                        allBook(book);
                        break;
                    default:
                        break;
                }
            }
        }
        return book;
    }
}