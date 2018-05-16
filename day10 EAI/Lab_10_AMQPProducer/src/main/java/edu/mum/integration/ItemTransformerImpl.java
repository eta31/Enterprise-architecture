package edu.mum.integration;

import edu.mum.domain.AuctionItem;
import edu.mum.domain.Item;
import org.springframework.integration.annotation.Transformer;

public class ItemTransformerImpl implements ItemTransformer {

	@Override
	@Transformer(inputChannel="inboundChannel", outputChannel="outboundChannel")
	public AuctionItem createAuctionItem(Item item) {
		AuctionItem auctionItem = new AuctionItem(	item, //item
													item.getName() + item.getVersion(), //auction id
													item.getVersion()); //version
		return auctionItem;
	}

}
