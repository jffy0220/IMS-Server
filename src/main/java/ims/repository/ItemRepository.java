package ims.repository;

import java.util.List;

import ims.models.Item;

public interface ItemRepository {
	List<Item> findByDateDeletedIsNull();
}