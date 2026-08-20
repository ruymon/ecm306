public class ex2 {

    static final int CAPACITY = 100;

    static class Patient {
        String name;
        int age;
        boolean pregnant;
        int priority;
        int arrival;
        String ticket;

        Patient(String name, int age, boolean pregnant, int priority, int arrival, int sequence) {
            this.name = name;
            this.age = age;
            this.pregnant = pregnant;
            this.priority = priority;
            this.arrival = arrival;
            this.ticket = "P" + priority + "-" + String.format("%03d", sequence);
        }
    }

    static Patient[] heap = new Patient[CAPACITY];
    static int[] sequences = new int[4];
    static int size = 0;
    static int arrivals = 0;

    static int definePriority(int age, boolean pregnant) {
        if (age > 80) return 0;
        if (age > 60) return 1;
        if (pregnant) return 2;
        return 3;
    }

    static String priorityLabel(int priority) {
        if (priority == 0) return "elderly over 80";
        if (priority == 1) return "elderly over 60";
        if (priority == 2) return "pregnant or postpartum";
        return "general";
    }

    static boolean comesFirst(Patient a, Patient b) {
        if (a.priority != b.priority) return a.priority < b.priority;
        return a.arrival < b.arrival;
    }

    static void swap(int i, int j) {
        Patient temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    static void siftUp(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (!comesFirst(heap[index], heap[parent])) return;
            swap(index, parent);
            index = parent;
        }
    }

    static void siftDown(int index) {
        while (true) {
            int left = 2 * index + 1;
            int right = 2 * index + 2;
            int first = index;
            if (left < size && comesFirst(heap[left], heap[first])) first = left;
            if (right < size && comesFirst(heap[right], heap[first])) first = right;
            if (first == index) return;
            swap(index, first);
            index = first;
        }
    }

    static Patient checkIn(String name, int age, boolean pregnant) {
        if (size == CAPACITY) return null;
        int priority = definePriority(age, pregnant);
        Patient patient = new Patient(name, age, pregnant, priority, ++arrivals, ++sequences[priority]);
        heap[size] = patient;
        size++;
        siftUp(size - 1);
        return patient;
    }

    static Patient callNext() {
        if (size == 0) return null;
        Patient next = heap[0];
        heap[0] = heap[size - 1];
        heap[size - 1] = null;
        size--;
        siftDown(0);
        return next;
    }

    static Patient peek() {
        if (size == 0) return null;
        return heap[0];
    }

    static boolean isEmpty() {
        return size == 0;
    }

    static String describe(Patient patient) {
        return patient.ticket + " " + patient.name + ", " + patient.age + " years, priority "
                + patient.priority + " (" + priorityLabel(patient.priority) + ")";
    }

    static void printQueue() {
        if (isEmpty()) {
            System.out.println("    queue is empty");
            return;
        }
        Patient[] backup = new Patient[size];
        int total = size;
        for (int i = 0; i < size; i++) backup[i] = heap[i];
        StringBuilder sb = new StringBuilder();
        int position = 1;
        while (!isEmpty()) {
            sb.append("    ").append(position).append(". ").append(describe(callNext()));
            if (!isEmpty()) sb.append("\n");
            position++;
        }
        for (int i = 0; i < total; i++) heap[i] = backup[i];
        size = total;
        System.out.println(sb);
    }

    public static void main(String[] args) {
        String[] names = {"Ana", "Bruno", "Carla", "Diego", "Elisa", "Fabio", "Gisele", "Heitor", "Iara", "Joao"};
        int[] ages = {34, 82, 65, 28, 71, 19, 30, 90, 45, 62};
        boolean[] pregnant = {false, false, false, false, false, false, true, false, true, false};

        System.out.println("Check-in:");
        for (int i = 0; i < names.length; i++) {
            Patient patient = checkIn(names[i], ages[i], pregnant[i]);
            System.out.println("    " + describe(patient));
        }

        System.out.println("Waiting queue in service order:");
        printQueue();

        System.out.println("Next patient: " + describe(peek()));

        System.out.println("Calling patients:");
        int called = 0;
        while (!isEmpty() && called < 4) {
            System.out.println("    " + describe(callNext()));
            called++;
        }

        System.out.println("Check-in after the first calls:");
        System.out.println("    " + describe(checkIn("Katia", 88, false)));
        System.out.println("    " + describe(checkIn("Lucas", 25, false)));

        System.out.println("Waiting queue in service order:");
        printQueue();

        System.out.println("Calling the remaining patients:");
        while (!isEmpty()) {
            System.out.println("    " + describe(callNext()));
        }

        System.out.println("Empty queue:");
        printQueue();
        System.out.println("callNext on empty queue: " + callNext());
    }
}
