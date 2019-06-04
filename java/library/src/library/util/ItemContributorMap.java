package library.util;

import library.items.Item;
import library.persons.Contributor;

public class ItemContributorMap {

    private Item item;
    private Long itemId;
    private Contributor contributor;
    private Long contributorId;

    public ItemContributorMap(Item item, Contributor contributor) {
        this.item = item;
        this.itemId = item.getItemId();
        this.contributor = contributor;
        this.contributorId = contributor.getContributorId();
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Long getItemId() {
        return itemId;
    }

    public Contributor getContributor() {
        return contributor;
    }

    public void setContributor(Contributor contributor) {
        this.contributor = contributor;
    }

    public Long getContributorId() {
        return contributorId;
    }

}
