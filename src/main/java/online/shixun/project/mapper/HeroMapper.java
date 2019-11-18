package online.shixun.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import online.shixun.project.pojo.HeroPojo;
@Mapper
public interface HeroMapper {

	List<HeroPojo> getHero();

	List<HeroPojo> queryHerosByType(HeroPojo hero);

	HeroPojo getHeroById(HeroPojo hero);

}
