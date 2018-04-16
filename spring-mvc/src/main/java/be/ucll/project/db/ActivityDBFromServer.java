package be.ucll.project.db;

import be.ucll.project.domain.Activity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class ActivityDBFromServer implements ActivityDb {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("activityPU");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    @Override
    public List<Activity> getActivities() {
        entityManager.clear();
        List activities =  entityManager.createQuery("Select c from Activity c", Activity.class).getResultList();
        return activities;
    }

    @Override
    public void addActivity(Activity newActivity) {
        checkEntityManager();
        entityManager.persist(newActivity);
        entityManager.getTransaction().commit();
    }

    @Override
    public void deleteActivity(long id) {
        checkEntityManager();
        String queryString = "delete from Activity where id =?1";
        int updateCount = entityManager.createQuery(queryString).setParameter(1, id).executeUpdate();
    }

    @Override
    public void updateActivity(long id, Activity activity) {
        checkEntityManager();


        String queryString = "update Activity set name=?1, description=?2, date=?3, startTime=?4, endTime=?5, location=?6 where id=?7";
        int updateCount = entityManager.createQuery(queryString).setParameter(1, activity.getName()).setParameter(2, activity.getDescription())
                .setParameter(3, activity.getDate()).setParameter(4, activity.getStartTime()).setParameter(5, activity.getEndTime())
                .setParameter(6, activity.getLocation()).setParameter(7, id).executeUpdate();

        entityManager.getTransaction().commit();
    }

    @Override
    public Activity getActivity(long id) {
        checkEntityManager();
        List activities =  entityManager.createQuery("Select c from Activity c where c.id = " + id, Activity.class).getResultList();
        return (Activity) activities.get(0);
    }

    private void checkEntityManager(){
        if(!(entityManager.getTransaction().isActive())){
            entityManager.getTransaction().begin();
        }
    }
}
