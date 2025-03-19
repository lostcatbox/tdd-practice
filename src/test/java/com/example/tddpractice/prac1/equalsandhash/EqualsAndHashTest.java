package com.example.tddpractice.prac1.equalsandhash;

import com.example.tddpractice.prac1.valueobjectpattern.VO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EqualsAndHashTest {
    // 목적: Equals 그리고 HashCode로 값 객체를 재정의할 경우 ==, equals는 동등성(메모리 참조값 상관없음), 동일성(메모리 참조값이 같은지 확인) 이 구별이 되는지에 대한 테스트
    // VO, NonVO 객체를 사용하여 테스트 진행
    @Test
    public void 값_객체_equals_일치_메모리주소_불일치_테스트() {
        String 동일한_텍스트 = "동일한 TEXT";
        VO vo1 = new VO(동일한_텍스트);
        VO vo2 = new VO(동일한_텍스트);
        Assertions.assertEquals(vo1, vo2);
        Assertions.assertTrue(vo1.equals(vo2));
        Assertions.assertFalse(vo1 == vo2); //equals와 hash를 적용해도 각 메모리 참조 주소는 다른것을 알수있음
        int identityHashCode1 = System.identityHashCode(vo1);
        System.out.println("identityHashCode1 = " + identityHashCode1);
        int identityHashCode2 = System.identityHashCode(vo2);
        System.out.println("identityHashCode2 = " + identityHashCode2);
        Assertions.assertFalse(identityHashCode1 == identityHashCode2); //equals와 hash를 적용해도 각 메모리 참조 주소는 다른것을 알수있음
    }

    @Test
    public void java_primitive_타입_동등성_동일성_둘다_일치_테스트() {
        int vo1 = 1;
        int vo2 = 1;
        Assertions.assertEquals(vo1, vo2);
//        Assertions.assertTrue(vo1.equals(vo2));
        Assertions.assertTrue(vo1 == vo2); //equals와 hash를 적용해도 각 메모리 참조 주소는 다른것을 알수있음
        int identityHashCode1 = System.identityHashCode(vo1);
        System.out.println("identityHashCode1 = " + identityHashCode1);
        int identityHashCode2 = System.identityHashCode(vo2);
        System.out.println("identityHashCode2 = " + identityHashCode2);
        Assertions.assertTrue(identityHashCode1 == identityHashCode2); //equals와 hash를 적용해도 각 메모리 참조 주소는 다른것을 알수있음
    }

    @Test
    public void java_reference도_Integer도_참조형이기때문에_동등성은_일치_동일성은_불일치_테스트() {
        Integer vo1 = new Integer(123124);
        Integer vo2 = new Integer(123124);
        Assertions.assertEquals(vo1, vo2);
        Assertions.assertTrue(vo1.equals(vo2));
        Assertions.assertFalse(vo1 == vo2); //equals와 hash를 적용해도 각 메모리 참조 주소는 다른것을 알수있음
        int identityHashCode1 = System.identityHashCode(vo1);
        System.out.println("identityHashCode1 = " + identityHashCode1);
        int identityHashCode2 = System.identityHashCode(vo2);
        System.out.println("identityHashCode2 = " + identityHashCode2);
        Assertions.assertFalse(identityHashCode1 == identityHashCode2); //equals와 hash를 적용해도 각 메모리 참조 주소는 다른것을 알수있음
    }


}
