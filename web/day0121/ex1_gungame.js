$(function () {
    /*
    총을 클릭시 0~11 사이의 난수발생후 해당번째의 인형을
    사라지게 하기
    이미 사라진 경우는 메세지
    */
    $(".gun").click(function () {
        //0~11 사이 난수 발생
        let idx = parseInt(Math.random() * 12);

        if ($(".sunban img").eq(idx).is(":hidden")) {
            $("#msg").html("꽝!!!" + (idx + 1) + "번째 인형은 없습니다");
        } else {
            $("#msg").html((idx + 1) + "번째 인형을 맞췄습니다");
            // $(".sunban img").eq(idx).fadeOut('fast');
            $(".sunban img").eq(idx).hide();
        }

        //hidden 갯수가 12이면 게임 끝
        let n = $(".sunban img:hidden").length;
        if (n == 12) {
            $("#msg").html("Game Over!!!");
        }
    });

    //돈을 클릭시 돈은 사라지고 나머지는 모두 초기화
    $(".money img").click(function () {
        $(".sunban img").show();
        $("#msg").html("");

        // $(this).css("visibility","hidden");//자리 차지
        $(this).css("display", "none");//자리 차지하지 않음
    });
});
