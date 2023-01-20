package org.zerock.jdbcex.util;

import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.modelmapper.convention.MatchingStrategies;

// ModelMapper의 설정을 변경하고 쉽게 사용할 수 있도록 MapperUtil을 enum으로 생성
public enum MapperUtil {
    INSTANCE;

    private ModelMapper modelMapper;

    MapperUtil() {
        this.modelMapper = new ModelMapper();
        this.modelMapper.getConfiguration()     // ModelMapper의 설정을 변경(private로 선언된 필드도 접근 가능하도록 변경)
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE)
                .setMatchingStrategy(MatchingStrategies.STRICT);
    }

    public ModelMapper get() {  // ModelMapper을 사용할 수 있도록 구성
        return modelMapper;
    }
}
