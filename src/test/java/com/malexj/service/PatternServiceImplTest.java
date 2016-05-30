package com.malexj.service;

import com.malexj.config.BaseConfigTest;
import com.malexj.exception.ImageNotAvailableException;
import com.malexj.model.entity.ImageEntity;
import com.malexj.model.entity.PatternEntity;
import com.malexj.model.enums.PatternTag;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.annotation.Rollback;

import static junit.framework.TestCase.assertEquals;


public class PatternServiceImplTest extends BaseConfigTest {

    @Autowired
    private PatternService patternService;

    @Autowired
    private ImageService imageService;

    @Test
    @Rollback
    public void save_test() {
        //give
        ImageEntity imageEntity = new ImageEntity();
        imageEntity.setAvailable(false);
        imageEntity.setName("image");
        imageEntity.setImg(new byte[]{12, 12, 53, 45, 12, 12});
        ImageEntity expectImage = imageService.save(imageEntity);

        PatternEntity expectPattern = new PatternEntity();
        expectPattern.setTag(PatternTag.CREATIONAL);
        expectPattern.setTitle("title");
        expectPattern.setText("textttttttt www");
        expectPattern.setImage(expectImage);

        //when
        PatternEntity actualPattern = patternService.save(expectPattern);

        //then
        assertEquals(expectPattern, actualPattern);
    }

    @Test
    @Rollback
    public void update_image_test() {
        //give
        ImageEntity imageEntity = new ImageEntity();
        imageEntity.setAvailable(false);
        imageEntity.setName("image");
        imageEntity.setImg(new byte[]{12, 12, 53, 45, 12, 12});
        ImageEntity expectImage = imageService.save(imageEntity);

        PatternEntity expectPattern = new PatternEntity();
        expectPattern.setTag(PatternTag.CREATIONAL);
        expectPattern.setTitle("title");
        expectPattern.setText("textttttttt www");
        expectPattern.setImage(expectImage);
        PatternEntity pattern = patternService.save(expectPattern);

        //when
        ImageEntity imageEntity2 = new ImageEntity();
        imageEntity2.setAvailable(false);
        imageEntity2.setName("image22");
        imageEntity2.setImg(new byte[]{122, 121, 53, 45, 12, 12});
        ImageEntity expectImage2 = imageService.save(imageEntity2);
        pattern.setImage(expectImage2);

        PatternEntity actualPattern = patternService.update(pattern);

        //then
        assertEquals(pattern, actualPattern);
        assertEquals(expectImage2, actualPattern.getImage());
        assertEquals(2, imageService.findAll().size());
    }

    @Test
    @Rollback
    public void update_pattern_test() {
        //give
        ImageEntity imageEntity = new ImageEntity();
        imageEntity.setAvailable(false);
        imageEntity.setName("image");
        imageEntity.setImg(new byte[]{12, 12, 53, 45, 12, 12});
        ImageEntity expectImage = imageService.save(imageEntity);

        PatternEntity expectPattern = new PatternEntity();
        expectPattern.setTag(PatternTag.CREATIONAL);
        expectPattern.setTitle("title");
        expectPattern.setText("textttttttt www");
        expectPattern.setImage(expectImage);
        PatternEntity pattern = patternService.save(expectPattern);

        //when
        pattern.setText(";;sfsfsgsgsdg");
        pattern.setTitle("totioprg");
        pattern.setTag(PatternTag.BEHAVIORAL);
        PatternEntity actualPattern = patternService.update(pattern);

        //then
        assertEquals(pattern, actualPattern);
        assertEquals(imageEntity, actualPattern.getImage());
    }

    @Test
    @Rollback
    public void delete_pattern_test() {
        //give
        ImageEntity imageEntity = new ImageEntity();
        imageEntity.setAvailable(false);
        imageEntity.setName("image");
        imageEntity.setImg(new byte[]{12, 12, 53, 45, 12, 12});
        ImageEntity expectImage = imageService.save(imageEntity);

        PatternEntity expectPattern = new PatternEntity();
        expectPattern.setTag(PatternTag.CREATIONAL);
        expectPattern.setTitle("title");
        expectPattern.setText("textttttttt www");
        expectPattern.setImage(expectImage);
        PatternEntity actualPattern = patternService.save(expectPattern);

        //when
        patternService.delete(actualPattern.getId());

        //then
        assertEquals(1, imageService.findAll().size());
        assertEquals(0, patternService.findAll().size());
    }


    @Test(expected = DataIntegrityViolationException.class)
    @Rollback
    public void delete_image_test() throws ImageNotAvailableException {
        //give
        ImageEntity imageEntity = new ImageEntity();
        imageEntity.setAvailable(false);
        imageEntity.setName("image");
        imageEntity.setImg(new byte[]{12, 12, 53, 45, 12, 12});
        ImageEntity expectImage = imageService.save(imageEntity);

        PatternEntity expectPattern = new PatternEntity();
        expectPattern.setTag(PatternTag.CREATIONAL);
        expectPattern.setTitle("title");
        expectPattern.setText("textttttttt www");
        expectPattern.setImage(expectImage);
        patternService.save(expectPattern);

        //when
        imageService.delete(expectImage.getId());

        //then
        assertEquals(1, imageService.findAll().size());
    }

}
