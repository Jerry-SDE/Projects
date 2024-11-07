package com.laioffer.twitch;


import com.laioffer.twitch.db.FavoriteRecordRepository;
import com.laioffer.twitch.db.ItemRepository;
import com.laioffer.twitch.db.UserRepository;
import com.laioffer.twitch.db.entity.FavoriteRecordEntity;
import com.laioffer.twitch.db.entity.ItemEntity;
import com.laioffer.twitch.db.entity.UserEntity;
import com.laioffer.twitch.model.ItemType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;


import java.time.Instant;
import java.util.List;


@Component
public class DevelopmentTester implements ApplicationRunner {


    private static final Logger logger = LoggerFactory.getLogger(DevelopmentTester.class);


    private final UserRepository userRepository;
    private final ItemRepository itemRepository;
    private final FavoriteRecordRepository favoriteRecordRepository;


    public DevelopmentTester(
            UserRepository userRepository,
            ItemRepository itemRepository,
            FavoriteRecordRepository favoriteRecordRepository
    ) {
        this.userRepository = userRepository;
        this.itemRepository = itemRepository;
        this.favoriteRecordRepository = favoriteRecordRepository;
    }


    @Override
    public void run(ApplicationArguments args) {
        UserEntity newUser = new UserEntity(null, "user0", "Foo", "Bar", "password");
        userRepository.save(newUser);
    }
}
