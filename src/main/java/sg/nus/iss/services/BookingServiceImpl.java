package sg.nus.iss.services;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import sg.nus.iss.repo.BookingRepository;

@Service
public class BookingServiceImpl implements BookingService {

	
	@Resource
	private BookingRepository brepos;
}
