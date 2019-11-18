package online.shixun.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import online.shixun.project.mapper.HeroMapper;
import online.shixun.project.pojo.HeroPojo;
@Service
public class HeroService {
	
	@Autowired
	HeroMapper heroMapper;
	public List<HeroPojo> getHero() {
		List<HeroPojo> list = heroMapper.getHero();
		return list;
	}
	public List<HeroPojo> queryHerosByType(HeroPojo hero) {
		return heroMapper.queryHerosByType(hero);
	}
	public HeroPojo getHeroById(HeroPojo hero) {
		HeroPojo hero1=heroMapper.getHeroById(hero);
		return hero1;
	}

}
