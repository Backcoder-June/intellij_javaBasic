package builder;

public class builderMain {
    public static void main(String[] args) {

        Member memberbuild = Member.builder()
                .age(12)
                .account("sadf")
                .email("sdaf")
                .password("1111")
                .emailSend(false)
                .build();


        Board boardByBuilder = Board.builder()
                .id(1L)
                .title("title")
                .content("contents")
                .writer("writer")
                .build();

        System.out.println(memberbuild);


    }
}
